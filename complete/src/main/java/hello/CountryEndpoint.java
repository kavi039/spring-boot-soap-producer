package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.Param0;
import io.spring.guides.gs_producing_web_service.Param0.Reply;

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
		System.out.println(".................................. 1");
		Param0 p = new Param0();
		Reply.Header header = new Reply.Header();
		header.setBatchId(request.getRequest().getHeader().getBatchId());
		Reply.DataBlock dataBlock = new Reply.DataBlock();
		Reply.DataBlock.MOBENQ mobenq = new Reply.DataBlock.MOBENQ();
		Reply.DataBlock.MOBENQ.Data data = new Reply.DataBlock.MOBENQ.Data();
		data.setActionId("ACtion1234");
		data.setServiceProvider("DLH");
		data.setContractType("FULL_TIME");
		data.setRespCode("200");
		data.setStatus("SUCCESS");
		mobenq.setData(data);
		dataBlock.setMOBENQ(mobenq);
		Param0.Reply reply = new Param0.Reply();
		reply.setHeader(header);
		reply.setDataBlock(dataBlock);
		p.setReply(reply);
//		request.getReply().getDataBlock().getMOBENQ().getData()
//				.setActionId(request.getRequest().getDataBlock().getMOBENQ().getData().getActionId());
		System.out.println(".................................. 2");
		return p;
	}
}
