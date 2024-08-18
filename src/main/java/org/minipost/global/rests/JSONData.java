package org.minipost.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData {
    private HttpStatus status = HttpStatus.OK; //상태코드
    private boolean success = true; //항상 성공할 수 있게끔
    private Object message;
    @NonNull
    private Object data;
}