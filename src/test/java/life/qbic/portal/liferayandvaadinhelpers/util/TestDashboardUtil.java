package de.uni_tuebingen.qbic.util;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.google.common.truth.Truth.ASSERT;

public class TestDashboardUtil {

  @Test
  public void testHumanReadableByteCount() {
    //bytes
    String target = DashboardUtil.humanReadableByteCount(0, false);    
    ASSERT.that(target).isEqualTo("0 B");
    target = DashboardUtil.humanReadableByteCount(0, true);    
    ASSERT.that(target).isEqualTo("0 B");

    target = DashboardUtil.humanReadableByteCount(24, false);    
    ASSERT.that(target).isEqualTo("24 B");
    
    target = DashboardUtil.humanReadableByteCount(24, true);    
    ASSERT.that(target).isEqualTo("24 B");
    
    //k bytes
    
    target = DashboardUtil.humanReadableByteCount(110592, false);    
    ASSERT.that(target).isEqualTo("108.0 KiB");
 
    target = DashboardUtil.humanReadableByteCount(110592, true);    
    ASSERT.that(target).comparesEqualTo("110.6 kB");
    ASSERT.that(target).isEqualTo("110.6 kB");
    
    

    
    //M bytes
    target = DashboardUtil.humanReadableByteCount(6787601, false);    
    ASSERT.that(target).isEqualTo("6.5 MiB");
    
    
    //G bytes
    
    target = DashboardUtil.humanReadableByteCount(8406772480L, false);    
    ASSERT.that(target).isEqualTo("7.8 GiB");
    
    target = DashboardUtil.humanReadableByteCount(106344247601L, false);    
    ASSERT.that(target).isEqualTo("99.0 GiB");

  }

}
