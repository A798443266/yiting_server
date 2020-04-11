package com.luo.yiting.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luo.yiting.bean.ParkAdmin;
import com.luo.yiting.bean.ParkingLot;
import com.luo.yiting.bean.User;
import com.luo.yiting.bean.UserSharePark;
import com.luo.yiting.cbmodel.ShareInfo;
import com.luo.yiting.service.ParkService;
import com.luo.yiting.service.UserService;
import com.luo.yiting.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.lwawt.macosx.CSystemTray;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class ParkController {

    @Autowired
    ParkService parkService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addShare", method = RequestMethod.POST)
    public Map addShare(
            @RequestParam(value = "pics", required = false) MultipartFile[] pics,
            @RequestParam("address") String address,
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude,
            @RequestParam(value = "type", defaultValue = "0") Integer type,
            @RequestParam("number") String number,
            @RequestParam("price") Float price,
            @RequestParam(value = "day", required = false) String day,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam("province") String province,
            @RequestParam("city") String city,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam("phone") String phone,
            @RequestParam("name") String name,
            @RequestParam("userId") Integer userId) {

        String path = System.getProperty("user.dir") + "/src/main/resources/static/image/sharepark";
        String picUrl = "";
        UserSharePark share = new UserSharePark();
        if (!StringUtils.isEmpty(pics)) {
            for (int i = 0; i < pics.length; i++) {
                String picName = pics[i].getOriginalFilename();
                String suffixName = picName.substring(picName.lastIndexOf("."));
                picName = UUID.randomUUID().toString().replace("-", "") + suffixName;
                File file = new File(path, picName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                picUrl += "/image/sharepark/" + picName + ",";
                //将上传文件保存到目标文件当中
                try {
                    pics[i].transferTo(new File(path + File.separator + picName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            picUrl = picUrl.substring(0, picUrl.length() - 1);
            share.setPic(picUrl);
        }

        if (!StringUtils.isEmpty(description)) {
            share.setDescription(description);
        }

        share.setDay(Util.stringFormatDate(day));
        share.setStarttime(Util.stringFormatTime(startTime));
        share.setEndtime(Util.stringFormatTime(endTime));
        share.setAddress(address);
        share.setPrice(price);
        share.setProvince(province);
        share.setCity(city);
        share.setLongitude(longitude);
        share.setLatitude(latitude);
        share.setUserid(userId);
        share.setName(name);
        share.setPhone(phone);
        share.setNumber(number);
        share.setType(type);

        int res = parkService.addSharePark(share);
        String msg = res > 0 ? "成功" : "失败";
        int code = res > 0 ? 200 : 500;
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        return map;
    }

    //用户查询指定地点范围内的共享车位和停车场
    @RequestMapping("/getAllShareInfo")
    public Map search(double latitude, double longitude) {
        Map<String, Object> map = new HashMap<>();
        List<ShareInfo> shareInfos = new ArrayList<>();
        List<UserSharePark> infos = parkService.getAllShareInfo(latitude, longitude);
        if (infos == null || infos.size() == 0) {
            map.put("userShare", shareInfos);
        } else {
            for (int i = 0; i < infos.size(); i++) {
                ShareInfo shareInfo = new ShareInfo();
                shareInfo.setUserSharePark(infos.get(i));
                // 根据userid 去查用户信息
                User user = userService.getUserById(infos.get(i).getUserid());
                shareInfo.setUser(user);
                shareInfos.add(shareInfo);
                map.put("userShare", shareInfos);
            }
        }

        List<ParkingLot> parks = parkService.getAllParkingLot(latitude, longitude);
        map.put("parkingLot", parks);
        return map;
    }

    @RequestMapping(value = "/addParkingLot", method = RequestMethod.POST)
    public Map addParkingLot(@RequestParam(value = "pics", required = false) MultipartFile[] pic,
                             @RequestParam("address") String address,
                             @RequestParam("latitude") Double latitude,
                             @RequestParam("longitude") Double longitude,
                             @RequestParam("price") Float price,
                             @RequestParam("province") String province,
                             @RequestParam("city") String city,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam("freeDuration") String freeDuration,
                             @RequestParam("cappedPrice") String cappedPrice,
                             @RequestParam("total") String total) {


        Map<String, Object> map = new HashMap<>();
        return map;
    }

    //获取所有未审核的共享车位信息
    @RequestMapping("/getUnVerifyShare")
    public Map getUnVerifyShare(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<UserSharePark> shareParks = parkService.getUnVerifyShare();
        List<ShareInfo> shareInfos = new ArrayList<>();
        for (int i = 0; i < shareParks.size(); i++) {
            ShareInfo shareInfo = new ShareInfo();
            shareInfo.setUserSharePark(shareParks.get(i));
            // 根据userid 去查用户信息
            User user = userService.getUserById(shareParks.get(i).getUserid());
            shareInfo.setUser(user);
            shareInfos.add(shareInfo);
        }
        PageInfo<ShareInfo> pageInfo = new PageInfo<>(shareInfos);
        shareInfos = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("shareInfos", shareInfos);
        map.put("total", shareInfos == null ? 0 : shareInfos.size());
        return map;
    }

    //根据用户id查询其共享的车位
    public Map getShareParks(Integer userId) {
        parkService.getShareParksByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @RequestMapping("/passVerify")
    public Map passVerify(Integer id) {
        int res = parkService.updateVerify(id, 1);
        int code = res == 0 ? 500 : 200;
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        return map;
    }

    @RequestMapping("/refuseVerify")
    public Map refuseVerify(Integer id) {
        int res = parkService.updateVerify(id, 2);
        int code = res == 0 ? 500 : 200;
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        return map;
    }

    //获取所有停车场
    @RequestMapping("/getAllParkingLot")
    public Map getAllParkingLot(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ParkingLot> parkingLots = parkService.getAllParkingLot();
        PageInfo<ParkingLot> pageInfo = new PageInfo<>(parkingLots);
        parkingLots = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("parkingLots", parkingLots);
        map.put("total", parkingLots == null ? 0 : parkingLots.size());
        return map;
    }


    //根据id查询停车场信息
    @RequestMapping("/getPakLotInfo")
    public Map getParkInfo(Integer parkLotId) {
        Map<String, Object> map = new HashMap<>();
        ParkingLot parkingLot = parkService.getParkingLogById(parkLotId);
        map.put("code", 200);
        map.put("parkingLot", parkingLot);
        return map;
    }

    //修改停车场信息
    @RequestMapping(value = "/updateParkingLot", method = RequestMethod.POST)
    public Map updateParkingLot(@RequestBody ParkingLot p) {
        int res = parkService.updateParkingLot(p);
        int code = res == 0 ? 500 : 200;
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        return map;
    }

    //根据用户id查询共享车位信息
    @RequestMapping("/getUserShareParks")
    public Map getUserSharesByserId(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Integer userId) {
        PageHelper.startPage(pageNo, pageSize);

        List<UserSharePark> shareParks = parkService.getUserShare(userId);
        PageInfo<UserSharePark> pageInfo = new PageInfo<>(shareParks);
        shareParks = pageInfo.getList();
        Map<String, Object> map = new HashMap<>();
        map.put("shareParks", shareParks);
        return map;
    }


}
