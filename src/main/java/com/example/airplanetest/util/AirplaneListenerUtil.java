package com.example.airplanetest.util;

import com.example.airplanetest.model.Airplane;
import com.example.airplanetest.service.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class AirplaneListenerUtil extends AbstractMongoEventListener<Airplane> {
    private final SequenceGeneratorService sequenceGenerator;

    public AirplaneListenerUtil(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Airplane> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator
                    .generateSequence(Airplane.SEQUENCE_NAME));
        }
    }
}
