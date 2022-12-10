package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;

public class ImageUpload extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        final String UPLOAD_DIR = "uploads";

        try {
            Part image = request.getPart("image");
            if(!image.getContentType().contains("image")){
                request.setAttribute("message", "Please provide a valid image!");
                return "Controller?command=ImageOverview";
            }
            String fileName = image.getSubmittedFileName();
            service.addImage(fileName);

            // gets absolute path of the web application
            String applicationPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

            // creates the save directory if it does not exists
            File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdirs();
            }
            System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());

            image.write(uploadFilePath + File.separator + fileName);

            request.setAttribute("message", fileName + " succesfull upload!");
        } catch (Exception e) {
            if (e.getMessage().contains("unique constraint")){
                request.setAttribute("message", "This image already exists.");
            } else { throw new RuntimeException(e.getMessage()); }
        }
        return "Controller?command=ImageOverview";
    }
}


