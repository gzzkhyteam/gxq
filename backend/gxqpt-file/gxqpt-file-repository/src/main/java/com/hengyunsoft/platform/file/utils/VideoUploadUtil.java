package com.hengyunsoft.platform.file.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoUploadUtil {
    private static String inputPath = "";

    //public static void main(String[] args) {
    //    processImage("I:\\test\\ffmpeg.exe",
    //            "I:\\test\\12.mp4",
    //            "2",
    //            "500x250");
    //    //processImg("I:\\test\\12.mp4","I:\\test\\ffmpeg.exe");
    //}

    /**
     * 视频截图
     *
     * @param ffmpegPath 系统上 ffmpeg 的路径
     * @param videoPath  本地视频路径
     * @param ss         截图时间 单位秒
     * @param s          尺寸大小
     * @return
     */
    public static String processImage(String ffmpegPath, String videoPath, String ss, String s) {
        File file = new File(videoPath);
        if (!file.exists()) {
            log.info("路径[{}]对应的视频文件不存在!", videoPath);
            return "";
        }
        String imagePath = videoPath.substring(0, videoPath.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg";
        log.info("imagePath={}", imagePath);

        //String commands = "%s -i %s -ss %s -vframes 1 -r 1 -ac 1 -ab 2 -s %s -f  image2 %s";

        List<String> commands = new java.util.ArrayList<>();
        commands.add(ffmpegPath);
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-ss");
        commands.add(ss);// 这个参数是设置截取视频多少秒时的画面
        commands.add("-vframes");
        commands.add("1");
        commands.add("-r");
        commands.add("1");
        commands.add("-ac");
        commands.add("1");
        commands.add("-ab");
        commands.add("2");
        commands.add("-s");
        commands.add(s);
        commands.add("-f");
        commands.add("image2");
        commands.add(imagePath);

        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            Process process = builder.start();
            process.waitFor(5, TimeUnit.SECONDS);
            log.info("截取成功");
            System.out.println(loadStream(process.getErrorStream()));
            return imagePath;
        } catch (Exception e) {
            log.error("截图异常", e);
            return "";
        }
    }

    /**
     * 音频抽取
     *
     * @param ffmpegPath 系统上 ffmpeg 的路径
     * @param videoPath  音频抽取路径
     * @return
     */
    public static String processAudioPath(String ffmpegPath, String videoPath) {
        File file = new File(videoPath);
        if (!file.exists()) {
            log.info("路径[{}]对应的视频文件不存在!", videoPath);
            return "";
        }
        String audioPath = videoPath.substring(0, videoPath.lastIndexOf(".")).replaceFirst("vedio", "file") + ".mp3";
        log.info("audioPath={}", audioPath);

        //String commands = "%s -i %s -ss %s -vframes 1 -r 1 -ac 1 -ab 2 -s %s -f  image2 %s";

        List<String> commands = setCommands(new String[]{
                ffmpegPath,
                "-i",
                videoPath,
                "-f",
                "mp3",
                "-vn",
                audioPath
        });

        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            Process process = builder.start();
            process.waitFor(5, TimeUnit.SECONDS);
            log.info("抽取异常");
            System.out.println(loadStream(process.getErrorStream()));
            return audioPath;
        } catch (Exception e) {
            log.error("抽取异常", e);
            return "";
        }
    }

    /**
     * 视频截取
     *
     * @param ffmpegPath 系统上 ffmpeg 的路径
     * @param videoPath  截取视频路径
     * @param videoPath  截取开始时间
     * @param videoPath  截取结束时间
     * @return
     */
    public static String videoConverter(String ffmpegPath, String videoPath, String startTime, String endTime) {
        File file = new File(videoPath);
        if (!file.exists()) {
            log.info("路径[{}]对应的视频文件不存在!", videoPath);
            return "";
        }
        String audioPath = videoPath.substring(0, videoPath.lastIndexOf(".")).replaceFirst("vedio", "file") + "-conv.wmv";
        log.info("audioPath={}", audioPath);

        List<String> commands = setCommands(new String[]{
                ffmpegPath,
                "-i",
                videoPath,
                "-y",
                "-ss",
                startTime,
                "-t",
                endTime,
                "-acodec",
                "copy",
                "-vcodec",
                "copy",
                audioPath
        });

        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            Process process = builder.start();
            process.waitFor(5, TimeUnit.SECONDS);
            log.info("抽取异常");
            System.out.println(loadStream(process.getErrorStream()));
            return audioPath;
        } catch (Exception e) {
            log.error("抽取异常", e);
            return "";
        }
    }

    static List<String> setCommands(String[] strs) {
        return Arrays.asList(strs);
    }

    static String loadStream(InputStream in) throws IOException {
        int ptr = 0;
        in = new BufferedInputStream(in);
        StringBuffer buffer = new StringBuffer();

        while ((ptr = in.read()) != -1) {
            buffer.append((char) ptr);
        }

        return buffer.toString();
    }

    public static String processImg(String videoPath, String ffmpegPath) {
        File file = new File(videoPath);
        if (!file.exists()) {
            log.info("路径[{}]对应的视频文件不存在!", videoPath);
            return "";
        }
        String imagePath = videoPath.substring(0, videoPath.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg";
        log.info("imagePath={}", imagePath);

        List<String> commands = new java.util.ArrayList<>();
        commands.add(ffmpegPath);
        commands.add("-i");
        commands.add(videoPath);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("2");// 这个参数是设置截取视频多少秒时的画面
        // commands.add("-t");
        // commands.add("0.001");
        commands.add("-s");
        commands.add("700x525");
        commands.add(imagePath);
        //log.info("commands={}", commands);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            log.info("截取成功");
            return imagePath;
        } catch (Exception e) {
            log.error("截图异常", e);
            return "";
        }
    }

    private static void getPath() { // 先获取当前项目路径，在获得源文件、目标文件、转换器的路径
        File diretory = new File("");
        try {
            String currPath = diretory.getAbsolutePath();
            //  String currPaths =currPath+"\\codeBySC2\\backend\\gxqpt-file\\gxqpt-file-api-impl\\src\\main\\resources\\ffmpeg\\ffmpeg.exe";
            inputPath = currPath + "/input/mv.avi";
            System.out.println(inputPath);
        } catch (Exception e) {
            System.out.println("getPath出错");
        }
    }

    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }


    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    //public static void main(String[] args) {
    //    getPath();
    //
    //    if (!checkfile(inputPath)) {
    //        System.out.println(inputPath + " is not file");
    //        return;
    //    }
    //    processImg(inputPath, "E:/ffmpeg/ffmpeg.exe");
    //}
}