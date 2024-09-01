package org.barbershop.api.utils;

import java.time.*;
import java.util.Date;

public class DateTimeUtils {

    public static OffsetDateTime ajustarFusoHorarioSaoPaulo(OffsetDateTime dataHora) {
        if (dataHora == null) {
            return null;
        }
        return dataHora.withOffsetSameInstant(ZoneOffset.of("-03:00"));
    }
}