package br.ufscar.dc.dsw.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

public class ImageController {
    private int maxFileSize;
    private int maxMemSize;
    private DiskFileItemFactory factory;
    private ServletFileUpload upload;

    ImageController(){
        maxFileSize = 5000 * 1024;
        maxMemSize  = 5000 * 1024;
    }

    public void DeleteFile(String location){

    }

    private void SetDiskItemFactory(){
        factory = new DiskFileItemFactory();
        
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File("\temp"));
    }

    public void SetServletFileItem(){
        if(factory == null)
            SetDiskItemFactory();

        upload = new ServletFileUpload(factory);
    }

    public ServletFileUpload GetServletFileItem(){
        if(this.upload == null)
            SetServletFileItem();

        return this.upload;
    }

    public void SaveFileList(String location, List fileItems){
        Iterator i = fileItems.iterator();

        while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();

            SaveFile(location, fi);            
        }
    }

    public void SaveFile(String location, FileItem fi){
        File dir = new File(location);
        if (!dir.exists()){dir.mkdirs();}

        File file;
        if ( !fi.isFormField () ) {
            // Get the uploaded file parameters
            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            
            // Write the file
            if( fileName.lastIndexOf("\\") >= 0 ) {
                file = new File( location + File.separator + fileName.substring( fileName.lastIndexOf("\\"))) ;
            } else {
                file = new File( location + File.separator + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }
            try{fi.write( file );}catch(Exception ex){System.out.println("Erro ao salvar arquivo" + ex);}
        }
    }
}
