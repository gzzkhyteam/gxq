//package com.hengyunsoft.platform.file.utils;
//
//import net.coobird.thumbnailator.Thumbnails;
//import net.coobird.thumbnailator.geometry.Positions;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class ImageCompressUtil {
////    /**
////     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩
////     *
////     * @param mfile        源图片
////     * @param absolutePath 目标图片地址
////     * @param widthdist    压缩后图片宽度（当rate==null时，必传）
////     * @param heightdist   压缩后图片高度（当rate==null时，必传）
////     * @param rate         压缩比例
////     */
////    public static void reduceImg(MultipartFile mfile, String absolutePath, int widthdist,
////                                 int heightdist, Float rate, String fileName, boolean keepRatio) {
////        try {
////            BufferedImage bf = ImageIO.read(mfile.getInputStream());
////            // 如果rate不为空说明是按比例压缩
////            if (rate != null && rate > 0) {
////                // 获取文件高度和宽度
////                int[] results = getImgWidth(bf);
////                if (results == null || results[0] == 0 || results[1] == 0) {
////                    return;
////                } else {
////                    widthdist = (int) (results[0] * rate);
////                    heightdist = (int) (results[1] * rate);
////                }
////            }
////            // 开始读取文件并进行压缩
////            Image src = (Image) bf;
////            BufferedImage tag = new BufferedImage((int) widthdist,
////                    (int) heightdist, BufferedImage.TYPE_INT_RGB);
////
////            tag.getGraphics().drawImage(
////                    src.getScaledInstance(widthdist, heightdist,
////                            Image.SCALE_SMOOTH), 0, 0, null);
////            writeCompress(mfile.getInputStream(),absolutePath,fileName,tag);
////        } catch (IOException ex) {
////            ex.printStackTrace();
////        }
////
////    }
////
////    /**
////     * 获取图片宽度
////     *
////     * @param file 图片文件
////     * @return 宽度
////     */
////    public static int[] getImgWidth(BufferedImage file) {
////        int result[] = {0, 0};
////        try {
////            result[0] = file.getWidth(); // 得到源图宽
////            result[1] = file.getHeight(); // 得到源图高
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return result;
////    }
////
////    public static boolean writeCompress(InputStream inputStream, String fileUploadPath, String fileName, BufferedImage tag) {
////        boolean ret = false;
////        File dir = new File(fileUploadPath);
////        if (!dir.exists()) {
////            dir.mkdirs();
////        }
////        File file = new File(fileUploadPath + File.separator + fileName);
////        try (OutputStream outputStream = new FileOutputStream(file)) {
////            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
////            encoder.encode(tag);
////            outputStream.close();
////            ret = true;
////        } catch (IOException e) {
////            e.printStackTrace();
////
////        } finally {
////            if (inputStream != null) {
////                try {
////                    inputStream.close();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            }
////        }
////        return ret;
////    }
//
//    /**
//     * 按大小压缩分辨率
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param widthdist
//     * @param heightdist
//     * @param keepRatio
//     */
//    public static void thumCompressForSize(MultipartFile fromPic, String fileUploadPath, String fileName, int widthdist,
//                                           int heightdist, boolean keepRatio) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        try {
//            Thumbnails.of(fromPic.getInputStream()).size(widthdist, heightdist).keepAspectRatio(keepRatio).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 按比例压缩分辨率
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param rate
//     */
//    public static void thumCompressForRatio(MultipartFile fromPic, String fileUploadPath, String fileName, float rate) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        try {
//            Thumbnails.of(fromPic.getInputStream()).scale(rate).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 旋转
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param rotate
//     */
//    public static void thumCompressForRotate(MultipartFile fromPic, String fileUploadPath, String fileName, float rotate) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        try {
//            Thumbnails.of(fromPic.getInputStream()).scale(1).rotate(rotate).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 改变图片质量
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param quality
//     */
//    public static void thumCompressQuality(MultipartFile fromPic, String fileUploadPath, String fileName, float quality) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        quality = quality > 1 ? 1 : quality;
//        int[] result = getImgWidth(fromPic);
//        try {
//            Thumbnails.of(fromPic.getInputStream()).size(result[0], result[1]).outputQuality(quality).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 修改文件类型
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param format
//     */
//    public static void thumFormat(MultipartFile fromPic, String fileUploadPath, String fileName, String format) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        int[] result = getImgWidth(fromPic);
//        try {
//            Thumbnails.of(fromPic.getInputStream()).size(result[0], result[1]).outputFormat(format.substring(1,format.length())).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 采用指定宽度、高度或压缩比例 的方式对图片进行压缩
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     * @param widthdist
//     * @param heightdist
//     * @param keepRatio
//     * @param rotate
//     * @param quality
//     * @param formate
//     */
//    public static void thumCombination(MultipartFile fromPic, String fileUploadPath, String fileName,
//                                       int widthdist, int heightdist, boolean keepRatio, float rotate, float quality, String formate) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        quality = quality > 1 ? 1 : quality;
//        try {
//            Thumbnails.of(fromPic.getInputStream()).size(widthdist, heightdist).keepAspectRatio(keepRatio).rotate(rotate).
//                    outputQuality(quality).outputFormat(formate).toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 水印
//     * @param fromPic
//     * @param waterPic
//     * @param fileUploadPath
//     * @param alpha
//     * @param fileName
//     */
//    public static void thumWatermark(MultipartFile fromPic, MultipartFile waterPic, String fileUploadPath, float alpha, String fileName) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        try {
//            int []result = getImgWidth(fromPic);
//            Thumbnails.of(fromPic.getInputStream()).size(result[0],result[1]).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(waterPic.getInputStream()), alpha).
//                    toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 剪切
//     * @param fromPic
//     * @param fileUploadPath
//     * @param fileName
//     */
//    public static void thumCut(MultipartFile fromPic, String fileUploadPath, String fileName) {
//        String filePath = fileUploadPath + File.separator + fileName;
//        try {
//            int []result = getImgWidth(fromPic);
//            Thumbnails.of(fromPic.getInputStream()).sourceRegion(600,500,400,400).size(200,200).keepAspectRatio(false).
//                    toFile(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取图片宽度
//     *
//     * @param file 图片文件
//     * @return 宽度
//     */
//    public static int[] getImgWidth(MultipartFile file) {
//        InputStream is = null;
//        BufferedImage src = null;
//        int result[] = {0, 0};
//        try {
//            is = file.getInputStream();
//            src = javax.imageio.ImageIO.read(is);
//            result[0] = src.getWidth(null); // 得到源图宽
//            result[1] = src.getHeight(null); // 得到源图高
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//}
