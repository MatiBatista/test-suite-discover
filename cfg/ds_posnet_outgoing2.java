import org.jpos.iso.*;
import org.jpos.space.*;
import java.util.*;
import ar.cabal.jpos.*;

void mapMtiAndPCode (String mti, String pcode, ISOMsg m) {
    Map map = new HashMap();
    map.put ("0100.00", "0100.00");
    map.put ("0100.02", "0100.02");
    map.put ("0100.22", "0100.22");
    map.put ("0100.20", "0100.20");
    map.put ("0100.30", "0100.31");
    map.put ("0200.00", "0200.00");
    map.put ("0200.02", "0200.02");
    map.put ("0200.22", "0200.02");
    map.put ("0200.20", "0200.20");
    map.put ("0220.00", "0220.00");
    map.put ("0400.00", "0400.00");
    map.put ("0420.00", "0420.00");
    map.put ("0800.00", "0800.00");
    map.put ("0800.00", "0800.00");
    
    String prefix = null;
    String suffix = "0000";
    if (pcode != null && pcode.length() == 6) {
        prefix = pcode.substring(0,2);
        suffix = pcode.substring(2);
    }
    String s = (String) map.get (mti + "." + prefix);
    if (s == null)
        s = (String) map.get (mti);
    s = s == null ? "9900" : s;
    StringTokenizer st = new StringTokenizer (s, ".");
    m.setMTI (st.nextToken());
    if (st.hasMoreTokens()) {
        m.set (3, st.nextToken() + suffix);
    }
}

String truncate (String s, int len) {
    if (s != null) {
        s = s.trim();
        if (s.length() > len)
            s = s.substring(0,len);
    }
    return s;
}

//ISOMsg m = (ISOMsg) message.clone(new int[] { 2,7,14,37,35,41,42 });
ISOMsg m = (ISOMsg) message.clone();
evt.addMessage ("--- original message (ds_posnet_outgoing) --");
evt.addMessage (message.clone());

        
if (message.hasField(37)) {
    Space sp = SpaceFactory.getSpace();
    evt.addMessage ("message key: " + "ds_posnet_" + message.getString(37));
}

try 
{
	//m.set(43,"HOTELÊMARABA           SAO PAULO      BR");
} catch (Exception e) {
    evt.addMessage ("--- ds_posnet_outgoing ---");
    evt.addMessage (e);
    throw e;
}

message = m;

