package com.example.tomcattest.servise;

import com.example.tomcattest.model.Generactive;
import com.example.tomcattest.servise.dto.GeneractiveDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenerativeService {
    Generactive save(GeneractiveDTO item);

    List<Generactive> getAll();

    void deleteById(Long id);

    Generactive getById(Long id);

    List<Generactive> getItemsWithPriceFromTo(int from, int to);

    Generactive updateById(Long id, GeneractiveDTO generativeDTO);
}
