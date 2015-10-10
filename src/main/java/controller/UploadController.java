package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
@RequestMapping("/")
public class UploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }

    @RequestMapping(value = "/upload")
    public ModelAndView onSubmit(@RequestParam("file") MultipartFile file)
            throws Exception {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File serverFile = getInputFile();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ModelAndView m = new ModelAndView("result");
        m.addObject("output", "result");
        return m;
    }

    private File getInputFile(){
        String name = "input.nb";
        // Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Create the file on server
        return new File(dir.getAbsolutePath()
                + File.separator + name);
    }

}
