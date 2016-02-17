package com.threerings.getdown.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class VersionUtilTest {
    @Test
    public void readVersion() throws IOException {
        File vfile = File.createTempFile("version", "txt");
        final String versionString = "2015051401";
        final Version version = Version.fromString(versionString);
        VersionUtil.writeVersion(vfile, version);
        final Version aversion = VersionUtil.readVersion(vfile);
        assert(!aversion.isNewerThan(version));
        assert(!version.isNewerThan(aversion));
        assert(aversion.toString().equals(versionString));
    }
}
