package com.Hackathon.Hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
 
public class App
{
  public static void main(String[] args) throws Exception
  {
    /*
	AWSCredentials credentials = new BasicAWSCredentials("AKIAIWM7CS2LNNXG2N6A", "oMsXFQ3hoABuErrhuvHGCb3lUXTCHV75ULvnib3q");
    AmazonEC2 ec2 = new AmazonEC2Client(credentials);
 
    DescribeInstancesResult insResult = ec2.describeInstances();
 
    int count = 1;
    for (Reservation reservation : insResult.getReservations())
    {
      for(Instance instance : reservation.getInstances())
      {
        System.out.println("Instance # " + count++
                + "\n InstanceId: " + instance.getInstanceId()
                + "\n InstanceType: " + instance.getInstanceType()
                + "\n Public IP: " + instance.getPublicIpAddress());
      }
    }
    
    */
	String answer = "";
	BufferedReader mail = null; //Lector
		try {
			//StringBuilder sb = new StringBuilder(); //función prueba
			File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/8ball.txt"); //Apertura del archivo y guardado en una variable de tipo File
			mail = new BufferedReader(new FileReader(file)); //Se le asigna el buffer para leer el archivo.
			System.out.println("I could open the file"); 
			List<String> lines = new ArrayList<String>(); //Creación variable de tipo ArrayList
			String line = mail.readLine(); //Creación de un string, asignándole la primera línea del archivo.
			while (line != null) { //Linea va a estar revisando que lo que lea no sea nulo. Mientras no lo sea, irá leyendo línea por línea el archivo.
				lines.add(line); //Se le añade la línea en la que está "line" al ArrayList"lines".
				//sb.append(line); //prueba
				//sb.append("\n"); //prueba
				mailManagement(lines);
				line = mail.readLine(); //Se va a la siguiente línea
			}
			//String archivo = sb.toString(); //prueba
			//System.out.println(archivo); //prueba
			//answer = lines.get(new Random().nextInt(lines.size()-1));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				mail.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  }
  
  AWSCredentials credentials = new BasicAWSCredentials("user key", "secret key"); //Erased it due to confidential issues (and the program not working)
  // Replace sender@example.com with your "From" address.
  // This address must be verified with Amazon SES.
  static final String FROM = "kimbellassistant@gmail.com";

  // Replace recipient@example.com with a "To" address. If your account
  // is still in the sandbox, this address must be verified.
  static final String TO = "alex_martinez6@hotmail.com";

  // The configuration set to use for this email. If you do not want to use a
  // configuration set, comment the following variable and the 
  // .withConfigurationSetName(CONFIGSET); argument below.
  static final String CONFIGSET = "ConfigSet";

  // The subject line for the email.
  static final String SUBJECT = "Kimbell Today";
  
  // The HTML body for the email.
  static final String HTMLBODY = "<h1>Kindle Today for Wizeline!</h1>"
      + "<p>Today's notifications are: ";

  // The email body for recipients with non-HTML email clients.
  static final String TEXTBODY = "This email was sent through Kimbell";

  	static String mailManagement(List list) {
  		String answer = "";
  		
  		return answer;
  	}
  
/*
    try {
      AmazonSimpleEmailService client = 
          AmazonSimpleEmailServiceClientBuilder.standard()
          // Replace US_WEST_2 with the AWS Region you're using for
          // Amazon SES.
            .withRegion(Regions.US_WEST_2).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(TO))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(HTMLBODY))
                  .withText(new Content()
                      .withCharset("UTF-8").withData(TEXTBODY)))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(SUBJECT)))
          .withSource(FROM)
          // Comment or remove the next line if you are not using a
          // configuration set
          .withConfigurationSetName(CONFIGSET);
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: " 
          + ex.getMessage());
    }
  }
  */
}

