package com.cat.zsy.rest.controller;

import com.cat.zsy.rest.dto.*;
import org.glassfish.grizzly.http.util.*;
import org.glassfish.jersey.media.multipart.*;
import org.slf4j.*;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

@Path("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    private static final String SAVE_PATH = "e:/upload";

    @POST
    @Path("/upload")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Result<String> upload(@FormDataParam("file") InputStream inputStream, @FormDataParam("file") FormDataContentDisposition metadata) {
        String fileName = metadata.getFileName();
        logger.info("receive file:{}", fileName);
        try {
            Files.copy(inputStream, Paths.get(SAVE_PATH, fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WebApplicationException("Error while uploading file. Please try again !!", e);
        }
        return Result.success("upload success");
    }

    @GET
    @Path("/download/{name}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("name") String name) {
        String filename = name + ".txt";

        StreamingOutput stream = output -> {
            try {

                java.nio.file.Path path = Paths.get(SAVE_PATH, filename);
//                SeekableByteChannel seekableByteChannel = Files.
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!", e);
            }
        };
        return Response
                .ok(stream, MediaType.APPLICATION_OCTET_STREAM)
                .header(Header.ContentDisposition.getLowerCase(), "attachment; file=" + filename)
                .build();
    }

    //TODO:
    private void copy(InputStream in, String name) throws IOException {
        long offset = 0;
        long quantum = 1 << 10;
        long count;

        java.nio.file.Path path = Paths.get(SAVE_PATH, name);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        FileChannel out = FileChannel.open(path, StandardOpenOption.APPEND);
        while ((count = out.transferFrom(Channels.newChannel(in), offset, quantum)) > 0) {
            System.out.println(">>>>>>>>>>>" + count);
            offset += count;
        }
    }
}
