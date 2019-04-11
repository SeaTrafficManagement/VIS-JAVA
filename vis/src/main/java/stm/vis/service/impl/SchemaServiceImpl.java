package stm.vis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stm.vis.data.messages.MessageType;
import stm.vis.model.Schema;
import stm.vis.repository.SchemaRepository;
import stm.vis.service.SchemaService;

@Service
public class SchemaServiceImpl implements SchemaService {

	@Autowired
	private SchemaRepository repository;

	@Override
	public Schema getRouteSchema() {
		return this.repository.findByName(MessageType.RTZ.name());
	}

	@Override
	public Schema getTextMessageSchema() {
		return this.repository.findByName(MessageType.TXTMSG.name());
	}

	@Override
	public Schema getPolygonSchema() {
		return this.repository.findByName(MessageType.S124.name());
	}

}
