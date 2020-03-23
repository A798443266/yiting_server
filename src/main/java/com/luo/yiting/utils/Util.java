package com.luo.yiting.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static final double pi = Math.PI; //3.141592654
    //地球平均半径6371km
    public static final double EARTH_RADIUS = 6371000;
    //测试好久，发现3535出来的是附近五公里- -!
    public static final double DISTANCE = 3535;

    public static Date stringFormatDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date stringFormatTime(String s) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param lat      纬度
     * @param lon      经度
     * @param distance 多少米范围
     * @return
     */
    public static double[] compute(double lat, double lon, double distance) {
        lat = lat * pi / 180;
        lon = lon * pi / 180;  //先换算成弧度
        double rad_dist = distance / EARTH_RADIUS;  //计算X公里在地球圆周上的弧度
        double lat_min = lat - rad_dist;
        double lat_max = lat + rad_dist;   //计算纬度范围
        double lon_min;
        double lon_max;
        //因为纬度在-90度到90度之间，如果超过这个范围，按情况进行赋值
        if (lat_min > -pi / 2 && lat_max < pi / 2) {
            //开始计算经度范围
            double lon_t = Math.asin(Math.sin(rad_dist) / Math.cos(lat));
            lon_min = lon - lon_t;
            //同理，经度的范围在-180度到180度之间
            if (lon_min < -pi)
                lon_min += 2 * pi;
            lon_max = lon + lon_t;
            if (lon_max > pi)
                lon_max -= 2 * pi;
        } else {
            lat_min = Math.max(lat_min, -pi / 2);
            lat_max = Math.min(lat_max, pi / 2);
            lon_min = -pi;
            lon_max = pi;
        }
        //最后置换成角度进行输出
        lat_min = lat_min * 180 / pi;
        lat_max = lat_max * 180 / pi;
        lon_min = lon_min * 180 / pi;
        lon_max = lon_max * 180 / pi;
        double result[] = {lat_min, lat_max, lon_min, lon_max};
        return result;
    }


    /**
     * 转化为弧度(rad)
     */
    public static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 基于余弦定理求两经纬度距离
     *
     * @param lon1 第一点的精度
     * @param lat1 第一点的纬度
     * @param lon2 第二点的精度
     * @param lat2 第二点的纬度
     * @return 返回的距离，单位m
     */

    public static double LantitudeLongitudeDist(double lat1, double lat2, double lon1, double lon2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);

        double radLon1 = rad(lon1);
        double radLon2 = rad(lon2);

        if (radLat1 < 0)
            radLat1 = Math.PI / 2 + Math.abs(radLat1);// south
        if (radLat1 > 0)
            radLat1 = Math.PI / 2 - Math.abs(radLat1);// north
        if (radLon1 < 0)
            radLon1 = Math.PI * 2 - Math.abs(radLon1);// west
        if (radLat2 < 0)
            radLat2 = Math.PI / 2 + Math.abs(radLat2);// south
        if (radLat2 > 0)
            radLat2 = Math.PI / 2 - Math.abs(radLat2);// north
        if (radLon2 < 0)
            radLon2 = Math.PI * 2 - Math.abs(radLon2);// west
        double x1 = EARTH_RADIUS * Math.cos(radLon1) * Math.sin(radLat1);
        double y1 = EARTH_RADIUS * Math.sin(radLon1) * Math.sin(radLat1);
        double z1 = EARTH_RADIUS * Math.cos(radLat1);

        double x2 = EARTH_RADIUS * Math.cos(radLon2) * Math.sin(radLat2);
        double y2 = EARTH_RADIUS * Math.sin(radLon2) * Math.sin(radLat2);
        double z2 = EARTH_RADIUS * Math.cos(radLat2);

        double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
        //余弦定理求夹角
        double theta = Math.acos((EARTH_RADIUS * EARTH_RADIUS + EARTH_RADIUS * EARTH_RADIUS - d * d)
                / (2 * EARTH_RADIUS * EARTH_RADIUS));
        double dist = theta * EARTH_RADIUS;
        return dist;
    }
}
