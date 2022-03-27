package ut.com.geneculling.javakata;

import com.geneculling.javakata.api.Timestamper;
import com.geneculling.javakata.impl.TimestamperImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TimestamperImplTest {
    @Test
    public void canary(){
        assertEquals(true, true);
    }
    
    @Test
    public void timestamperImplShouldBeAbleToBeCreated(){
        Timestamper timestamperImpl = new TimestamperImpl();
    }

    @Test
    public void timestamperInterfaceShouldCreateDateFromValidMillisecondsString(){
        Date date = Timestamper.getDateFromMillisecondsString("1451001600000");
        assertEquals(date, new Date(1451001600000l));
    }

    @Test
    public void timestamperInterfaceShould_Not_CreateDateFromInvalidMillisecondsString(){
        Date date = Timestamper.getDateFromMillisecondsString("");
        assertEquals(date, null);
    }

    @Test
    public void timestamperShouldReturnValidJsonFromDate_unix(){
        Date date = new Date(1451001600000l);
        Timestamper timestamper = new TimestamperImpl();
        JsonObject json = timestamper.getJsonFromDate(date);
        assertEquals(1451001600000l, json.get("unix").getAsLong());
    }

    @Test
    public void timestamperShouldReturnValidJsonFromDate_utc(){
        Date date = new Date(1451001600000l);
        Timestamper timestamper = new TimestamperImpl();
        JsonElement json = timestamper.getJsonFromDate(date);
        assertEquals("Fri, 25 Dec 2015 00:00:00 GMT", json.getAsJsonObject().get("utc").getAsString());
    }

    @Test
    public void getUtcString(){
        Date date = new Date(1451001600000l);
        String utc = TimestamperImpl.getUtcString(date);
        assertEquals("Fri, 25 Dec 2015 00:00:00 GMT", utc);
    }

}

