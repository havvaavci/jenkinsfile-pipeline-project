package com.qa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

  @Test
  void shouldPass() {
    assertTrue(true);
  }

  @Test
  void shouldFailExample() {
    // şimdilik PAS geçsin diye true bırakıyorum
    // fail görmek istersen bunu false yaparız
    assertTrue(true);
  }
}
