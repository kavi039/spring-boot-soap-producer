package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.Param0;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "param0")
	@ResponsePayload
	public Param0 getCountry(@RequestPayload Param0 request) {
//		Param0 response = new Param0();
		System.out.println("..............................."
				+ request.getRequest().getDataBlock().getMOBENQ().getData().getActionId());

		// response.getReply().getDataBlock().getMOBENQ().getData().setServiceProvider("adgjgef");
		// response.setReply(countryRepository.findCountry("Spain"));

		return request;
	}
}
