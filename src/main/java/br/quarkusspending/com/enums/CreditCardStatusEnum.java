package br.quarkusspending.com.enums;

import br.quarkusspending.com.exceptions.MessageExceptions;

public enum CreditCardStatusEnum {
    ACTIVE,
    DELETED;

    public static CreditCardStatusEnum fromString(String value) {
        for (CreditCardStatusEnum cardStatuEnum : CreditCardStatusEnum.values()) {
            if (cardStatuEnum.toString().equals(value)) {
                return cardStatuEnum;
            }
        }
        throw new MessageExceptions("profile não encontrado");
    }
}
