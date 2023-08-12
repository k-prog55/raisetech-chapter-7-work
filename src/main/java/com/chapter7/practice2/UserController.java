package com.chapter7.practice2;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//User情報を取得/登録/更新/削除するAPIを作成
@RestController
@Validated
//User情報を扱うのでUserControllerとした（※映画情報ならMovieController,銀行口座ならBankAccountControllerにする）
public class UserController {

    //id、名前、生年月日(/user?id=17を受け取るGETリクエストを作成
    @GetMapping("/user")
    public User getUser(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String birthDate) {
        User user = new User(id, name, birthDate);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers(
            @RequestParam List<Long> id,
            @RequestParam List<String> name,
            @RequestParam List<String> birthDate) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            User user = new User(id.get(i), name.get(i), birthDate.get(i));
            users.add(user);
        }
        return users;
    }

    //クエリ文字列(/names?name=shohei)を受け取るGETリクエストを作成
    @GetMapping("/names")
    public String getUserName(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //id、名前、生年月日を登録するPOSTリクエストの実装（nameがnameが空文字、null、20文字以上の場合はエラーとする）
    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateForm form, UriComponentsBuilder uriBuilder) {
        URI url = uriBuilder
                .path("/users/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    //バリデーションエラーの処理を行う@ExceptionHandleアノテーションを実装
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        bindingResult.getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    //PATCHリクエストの実装
    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated UpdateForm form) {
        //更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    //DELETEリクエストの実装
    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}
