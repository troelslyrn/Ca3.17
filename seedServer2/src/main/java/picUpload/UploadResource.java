///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package picUpload;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Produces;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DefaultValue;
//import javax.ws.rs.GET;
//import static javax.ws.rs.HttpMethod.POST;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PUT;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
//import org.glassfish.jersey.media.multipart.FormDataParam;
//
///**
// * REST Web Service
// *
// * @author Troels
// */
//@Path("upload")
//public class UploadResource {
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of UploadResource
//     */
//    public UploadResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of com.mycompany.fileupload.UploadResource
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of UploadResource
//     * @param content representation for the resource
//     */
//    public static final String FILE_LOCATION = "C:\\Users\\Troels\\Desktop\\3 Semester 2017\\Ca3.17\\img"
//            + "";
//    
//   @Path("/file")
//  @POST
//  @Consumes(MediaType.MULTIPART_FORM_DATA)
//  public Response uploadFile(@DefaultValue("") @FormDataParam("user") String user,
//          @FormDataParam("file") InputStream file,
//          @FormDataParam("file") FormDataContentDisposition fileDisposition) throws IOException {
//
//    System.out.println("Just to show how to send additonal data: "+ user);
//    String fileName = fileDisposition.getFileName();
//    saveFile(file, fileName);
//    String status = "{\"status\":\"uploaded\"}";
//    return Response.ok(status).build();
//  }
//
//  private void saveFile(InputStream is, String fileLocation) throws IOException {
//    String location = FILE_LOCATION + fileLocation;
//    try (OutputStream os = new FileOutputStream(new File(location))) {
//      byte[] buffer = new byte[256];
//      int bytes = 0;
//      while ((bytes = is.read(buffer)) != -1) {
//        os.write(buffer, 0, bytes);
//      }
//    }
//  }
//}