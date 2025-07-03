package zhant.enviaEmailMicroservice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import zhant.enviaEmailMicroservice.dto.EmailDto;
import zhant.enviaEmailMicroservice.models.EmailEntity;
import zhant.enviaEmailMicroservice.services.EmailService;

@RestController
public class EmailController {

	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sending-email")
	public ResponseEntity<EmailEntity> sendingEmail(@RequestBody @Valid EmailDto emailDto){
		
		EmailEntity emailEntity = new EmailEntity();
		BeanUtils.copyProperties(emailDto, emailEntity);//converte de DTO para entity, cola as propriedades
		emailService.sendEmail(emailEntity);
		return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
	}
}
