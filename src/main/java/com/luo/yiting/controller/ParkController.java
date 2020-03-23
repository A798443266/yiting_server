package com.luo.yiting.controller;

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
            @RequestParam("price") Double price,
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
                System.out.println("-:" + pics[i].getName());
                String picName = pics[i].getOriginalFilename();
                System.out.println("--:" + picName);
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
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }


    @RequestMapping("/getAllShareInfo")
    public Map search(double latitude, double longitude) {
        Map<String, Object> map = new HashMap<>();
        List<ShareInfo> shareInfos = new ArrayList<>();
        List<UserSharePark> infos = parkService.getAllShareInfo(latitude, longitude);
        if (infos == null || infos.size() == 0) {
            map.put("sharepark", infos);
            return map;
        }
        for (int i = 0; i < infos.size(); i++) {
            ShareInfo shareInfo = new ShareInfo();
            shareInfo.setUserSharePark(infos.get(i));
            // 根据userid 去查用户信息
            User user = userService.getUserById(infos.get(i).getUserid());
            shareInfo.setUser(user);
            shareInfos.add(shareInfo);
        }

        List<ParkingLot> parks = parkService.getAllParkingLot(latitude, longitude);
        map.put("parkingLot", parks);
        map.put("userShare", shareInfos);
        return map;
    }
}
