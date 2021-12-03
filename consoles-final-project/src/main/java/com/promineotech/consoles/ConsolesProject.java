package com.promineotech.consoles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

/**
 * @author Shawn O'Brien
 *
 */
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class ConsolesProject {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // Starts the entire application
    SpringApplication.run(ConsolesProject.class, args);
  }

}
