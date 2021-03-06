/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.msf4j.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 * Hello service resource class.
 */
@Path("/hello")
public class HelloService {

    @GET
    @Path("/{name}")
    public String hello(@PathParam("name") String name) {
        System.out.println("Hello");
        return "Hello " + name;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response streamExample() {
        StreamingOutput stream = os -> {
            Writer writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write("###### test ######");
            System.out.println("++++++ wrote it ++++++++");
            writer.flush();
        };
        return Response.ok(stream).build();
    }

}
