package eu.europa.ec.agri.beerbar.controller;

import eu.europa.ec.agri.beerbar.command.OpenTab;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@RestController
@RequestMapping(value = "/main")
@CrossOrigin(allowedHeaders = "*", exposedHeaders = "Content-Range", allowCredentials = "true")
@Api("Operations used in the tab management")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TabController {

  private final CommandGateway commandGateway;

  @PostMapping(path = "/tab")
  @ApiOperation("Opens a new tab")
  public ResponseEntity<String> openTab(
      @RequestBody OpenTab command) {

    UUID result = commandGateway.sendAndWait(command);

    return new ResponseEntity<>(result.toString(), HttpStatus.OK);
  }

}
