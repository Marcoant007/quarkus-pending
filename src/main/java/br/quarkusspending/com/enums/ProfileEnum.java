package br.quarkusspending.com.enums;

import br.quarkusspending.com.exceptions.MessageExceptions;

public enum ProfileEnum {
    ADMIN,
    USER,
    VISITOR;

    public static ProfileEnum fromString(String value) {
        for (ProfileEnum profileEnum : ProfileEnum.values()) {
            if (profileEnum.toString().equals(value)) {
                return profileEnum;
            }
        }
        throw new MessageExceptions("profile não encontrado");
    }
}
