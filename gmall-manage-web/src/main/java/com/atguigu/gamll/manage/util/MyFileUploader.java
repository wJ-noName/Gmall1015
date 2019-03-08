package com.atguigu.gamll.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class MyFileUploader {
    public static String uploadImage(MultipartFile multipartFile){
        String url = "http://192.168.85.19";

        try {
            String path = MyFileUploader.class.getClassLoader().getResource("tracker.conf").getPath();

            ClientGlobal.init(path);

            TrackerClient trackerClient = new TrackerClient();

            TrackerServer connection = trackerClient.getConnection();

            StorageClient storageClient = new StorageClient(connection, null);

            byte[] bytes = multipartFile.getBytes();

            String originalFilename = multipartFile.getOriginalFilename();

            int i = originalFilename.lastIndexOf(".");

            String substring = originalFilename.substring(i + 1);

            String[] strings = storageClient.upload_file(bytes, substring, null);

            for (String string : strings) {
                url = url + "/" + string;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
        }
}
