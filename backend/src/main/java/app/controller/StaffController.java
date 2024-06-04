package app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.StaffDTO;
import app.response.ResponseObject;
import app.response.StaffResponse;
import app.service.impl.StaffServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/staffs")
@RequiredArgsConstructor
public class StaffController {

    private final StaffServiceImpl staffService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAll() {
        try {
            List<StaffResponse> staffReponses = staffService.getAll();
            return ResponseEntity.ok(ResponseObject.builder()
                    .status(200)
                    .data(staffReponses)
                    .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(ResponseObject.builder()
                    .status(400)
                    .message("Update staff failed")
                    .data(e.getMessage())
                    .build());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseObject> getEmail(@PathVariable("email") String email) {
        try {
            StaffResponse staffResponse = staffService.getOne(email);
            return ResponseEntity.ok(ResponseObject.builder()
                    .status(200)
                    .data(staffResponse)
                    .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(ResponseObject.builder()
                    .status(400)
                    .message("Update staff failed")
                    .data(e.getMessage())
                    .build());
        }
    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> Post(@RequestBody StaffDTO staffDTO) {
        try {
            StaffResponse staffResponse = staffService.Post(staffDTO);
            return ResponseEntity.ok(ResponseObject.builder()
                    .status(200)
                    .data(staffResponse)
                    .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(ResponseObject.builder()
                    .status(400)
                    .message("Update staff failed")
                    .data(e.getMessage())
                    .build());
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<ResponseObject> Put(@PathVariable("email") String email, @RequestBody StaffDTO staffDTO) {
        try {
            StaffResponse staffResponse = staffService.Put(email, staffDTO);
            return ResponseEntity.ok(ResponseObject.builder()
                    .status(200)
                    .data(staffResponse)
                    .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(ResponseObject.builder()
                    .status(400)
                    .message("Update staff failed")
                    .data(e.getMessage())
                    .build());
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<ResponseObject> Delete(@PathVariable("email") String email) {
        try {
            staffService.Delete(email);
            return ResponseEntity.ok(ResponseObject.builder()
                    .status(200)
                    .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(ResponseObject.builder()
                    .status(400)
                    .message("Update staff failed")
                    .data(e.getMessage())
                    .build());
        }
    }
}