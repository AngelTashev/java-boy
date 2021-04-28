package assembler;

import java.util.HashMap;
import java.util.Map;

public class OpcodeMap {

    private static final Map<String, String> map = new HashMap<>()
    {{
        put("ADD A,B", "80");
        put("ADD A,D", "80");
        put("ADD A,B", "80");
        put("ADD A,B", "80");
    }};

}
