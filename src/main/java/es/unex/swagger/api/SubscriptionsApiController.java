package es.unex.swagger.api;


import es.unex.asee.gb01.contents.entities.SubscriptionEntity;
import es.unex.asee.gb01.contents.entities.UserEntity;
import es.unex.asee.gb01.contents.mappers.SubscriptionMapper;
import es.unex.asee.gb01.contents.repositories.SubscriptionRepository;
import es.unex.asee.gb01.contents.repositories.UserRepository;
import es.unex.swagger.model.Subscription;
import es.unex.swagger.model.SubscriptionType;
import es.unex.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.unex.swagger.model.UserLogIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-10-18T10:29:32.211856553Z[GMT]")
@RestController
public class SubscriptionsApiController implements SubscriptionsApi {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionsApiController.class);

    
    private final ObjectMapper objectMapper;

    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    UserRepository userRepository;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscriptionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteAllSubscriptions(
@Parameter(in = ParameterIn.COOKIE, description = "" ,required=true,schema=@Schema()) @CookieValue(value="SessionUserCookie", required=true) User sessionUserCookie) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteSubscriptionByIdSubscription(@Parameter(in = ParameterIn.PATH, description = "Id de la suscripción.", required=true, schema=@Schema()) @PathVariable("idSubscription") Long idSubscription
,
@Parameter(in = ParameterIn.COOKIE, description = "" ,required=true,schema=@Schema()) @CookieValue(value="User", required=true) String sessionUserCookie) {
        String accept = request.getHeader("Accept");

        subscriptionRepository.deleteById(idSubscription);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Subscription>>(objectMapper.readValue("[ {\n  \"idSubscription\" : 1,\n  \"tipo-subscription\" : {\n    \"Quantity\" : 6.0274563,\n    \"id-tipo-subscription\" : 0,\n    \"Name-tipo-subscription\" : \"Name-tipo-subscription\"\n  },\n  \"startDate\" : \"08/10/2022\",\n  \"idUser\" : 0,\n  \"endDate\" : \"08/10/2024\"\n}, {\n  \"idSubscription\" : 1,\n  \"tipo-subscription\" : {\n    \"Quantity\" : 6.0274563,\n    \"id-tipo-subscription\" : 0,\n    \"Name-tipo-subscription\" : \"Name-tipo-subscription\"\n  },\n  \"startDate\" : \"08/10/2022\",\n  \"idUser\" : 0,\n  \"endDate\" : \"08/10/2024\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Subscription>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Subscription>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscription> postSubscriptionByUser(
@Parameter(in = ParameterIn.COOKIE, description = "" ,required=true,schema=@Schema()) @CookieValue(value="User", required=true) String sessionUserCookie,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Subscription body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                UserEntity user = userRepository.findByEmail(sessionUserCookie);
                UserEntity userSubs = userRepository.findById(body.getIdSubscription()).orElse(null);
                SubscriptionEntity subscription = SubscriptionMapper.toEntity(body);
                if(subscription.getidUser() != user.getIdUser()){
                    return new ResponseEntity<Subscription>(HttpStatus.BAD_REQUEST);
                }
                if(userSubs == null){
                    return new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND);
                }
                SubscriptionEntity savedSubs = subscriptionRepository.save(subscription);
                return new ResponseEntity<Subscription>( HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Subscription> updateSubscriptionByIdSubscription(@Parameter(in = ParameterIn.PATH, description = "Id de la suscripción.", required=true, schema=@Schema()) @PathVariable("idSubscription") Integer idSubscription
,
@Parameter(in = ParameterIn.COOKIE, description = "" ,required=true,schema=@Schema()) @CookieValue(value="SessionUserCookie", required=true) User sessionUserCookie,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Subscription body
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Subscription>(objectMapper.readValue("{\n  \"idSubscription\" : 1,\n  \"tipo-subscription\" : {\n    \"Quantity\" : 6.0274563,\n    \"id-tipo-subscription\" : 0,\n    \"Name-tipo-subscription\" : \"Name-tipo-subscription\"\n  },\n  \"startDate\" : \"08/10/2022\",\n  \"idUser\" : 0,\n  \"endDate\" : \"08/10/2024\"\n}", Subscription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Subscription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Subscription>(HttpStatus.NOT_IMPLEMENTED);
    }

}
