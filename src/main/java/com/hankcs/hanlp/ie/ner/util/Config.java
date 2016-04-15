package com.hankcs.hanlp.ie.ner.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by roy on 2016/4/15.
 */

public class Config {
    public Set<String> orgTagging;
    public Set<String> personTagging;

    public Config(){
        orgTagging = loadOrganizationTagging();
        personTagging = loadPersonNameTagging();
    }

    private Set<String> loadOrganizationTagging() {
        Set<String> nature = new HashSet<String>();
        nature.add("nz");
        nature.add("ntc");
        nature.add("nt");
        nature.add("nio");
        nature.add("ni");
        nature.add("ntcb");
        nature.add("ntcf");
        nature.add("ntch");
        return nature;
    }

    private Set<String> loadPersonNameTagging() {
        Set<String> nature = new HashSet<String>();
        nature.add("nr");
        return nature;
    }
}
