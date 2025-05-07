package org.koreait.global.validators;

public interface IdValidator {
    default int stringToId(String searchId) {
        // 숫자인지 확인
        if (searchId.matches("\\d+")) {
            int postId = Integer.parseInt(searchId);
            return postId;
        } else {
            return -1;
        }
    }
}
