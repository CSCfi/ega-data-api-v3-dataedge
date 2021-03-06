/*
 * Copyright 2017 ELIXIR EBI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.elixir.ega.ebi.dataedge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eu.elixir.ega.ebi.dataedge.service.TicketService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author asenf
 */
@RestController
@EnableDiscoveryClient
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    
    @RequestMapping(value = "/files/{file_id}", method = GET)
    public Object getTicket(@PathVariable String file_id,
                            @RequestParam(name = "format", required = false, defaultValue = "BAM") String format,
                            @RequestParam(name = "referenceIndex", required = false, defaultValue = "-1") Integer referenceIndex,
                            @RequestParam(name = "referenceName", required = false, defaultValue = "") String referenceName,
                            @RequestParam(name = "referenceMD5", required = false, defaultValue = "") String referenceMD5,
                            @RequestParam(name = "start", required = false, defaultValue = "") String start,
                            @RequestParam(name = "end", required = false, defaultValue = "") String end,
                            @RequestParam(name = "fields", required = false) List<String> fields,
                            @RequestParam(name = "tags", required = false) List<String> tags,
                            @RequestParam(name = "notags", required = false) List<String> notags,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ticketService.getTicket(auth, 
                                       file_id,
                                       format,
                                       referenceIndex,
                                       referenceName,
                                       referenceMD5,
                                       start,
                                       end,
                                       fields,
                                       tags,
                                       notags,
                                       request,
                                       response);
    }    

    @RequestMapping(value = "/direct/{file_id}", method = GET)
    public Object getDirectTicket(@PathVariable String file_id,
                                  @RequestParam(name = "format", required = false, defaultValue = "BAM") String format,
                                  @RequestParam(name = "referenceIndex", required = false, defaultValue = "-1") Integer referenceIndex,
                                  @RequestParam(name = "referenceName", required = false, defaultValue = "") String referenceName,
                                  @RequestParam(name = "referenceMD5", required = false, defaultValue = "") String referenceMD5,
                                  @RequestParam(name = "start", required = false, defaultValue = "") String start,
                                  @RequestParam(name = "end", required = false, defaultValue = "") String end,
                                  @RequestParam(name = "fields", required = false) List<String> fields,
                                  @RequestParam(name = "tags", required = false) List<String> tags,
                                  @RequestParam(name = "notags", required = false) List<String> notags,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return ticketService.getTicket(auth, 
                                       file_id,
                                       format,
                                       referenceIndex,
                                       referenceName,
                                       referenceMD5,
                                       start,
                                       end,
                                       fields,
                                       tags,
                                       notags,
                                       request,
                                       response);
    }    
}
