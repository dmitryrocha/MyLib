package br.com.mylib.mylib.controller;

import br.com.mylib.mylib.dto.PublishingCreateDto;
import br.com.mylib.mylib.dto.PublishingDto;
import br.com.mylib.mylib.mapper.PublishingMapper;
import br.com.mylib.mylib.model.Publishing;
import br.com.mylib.mylib.service.PublishingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishing")
public class PublishingController {

    private final PublishingService service;
    private final PublishingMapper mapper;

    public PublishingController(PublishingService service, PublishingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PublishingDto>> findAll() {
        List<Publishing> publishingList = service.findAl();
        return ResponseEntity.ok(mapper.toPublishingDtoList(publishingList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublishingDto> findById(@PathVariable Long id) {
        Publishing publishing = service.findById(id);
        return ResponseEntity.ok(mapper.toPublshingDto(publishing));
    }

    @PostMapping
    public ResponseEntity<PublishingDto> create(@RequestBody PublishingCreateDto publishingCreateDto) {
        var publishingCreate = mapper.toPublishingCreate(publishingCreateDto);
        var publishing = service.create(publishingCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPublshingDto(publishing));
    }

    @PostMapping("/{id}")
    public ResponseEntity<PublishingDto> update(@PathVariable Long id, @RequestBody PublishingCreateDto publishingCreateDto) {
        var publishingCreate = mapper.toPublishingCreate(publishingCreateDto);
        var publishing = service.update(id, publishingCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPublshingDto(publishing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
