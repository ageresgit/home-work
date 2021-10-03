package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

import java.util.Collection;

public class XMLUtils {
    public static String toXML(Request request) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(request);
    }


    public static String toXML(Response response) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(response);
    }

    public static Request XMLtoRequest(String requestJSON) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(requestJSON, Request.class);
    }

    public static Response XMLtoResponse(String responseJSON) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(responseJSON, Response.class);
    }
}
