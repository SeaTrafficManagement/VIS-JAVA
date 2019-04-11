package stm.vis.ssc.client.data;

import java.math.BigInteger;

public class FindIdentitiesResponseObj {

    protected String body;
    protected BigInteger statusCode;

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public BigInteger getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(BigInteger value) {
        this.statusCode = value;
    }

}
