package stm.vis.ssc.client.data;

import java.util.ArrayList;
import java.util.List;

public class IdentityRegistryGeneralRequestObj {

    protected RequestType requestType;
    protected String url;
    protected List<Header> headers;
    protected String body;

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType value) {
        this.requestType = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public List<Header> getHeaders() {
        if (headers == null) {
            headers = new ArrayList<Header>();
        }
        return this.headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

}
