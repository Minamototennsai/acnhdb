package com.ecnudbcourse.acnhdb.service;

import com.ecnudbcourse.acnhdb.entity.Music;
import com.ecnudbcourse.acnhdb.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public List<Music> findByName(String name) { return musicMapper.findByName(name); }

    public int insertMusic(Music music) { return musicMapper.insertMusic(music); }

    public int updateMusic(Music music) { return musicMapper.updateMusic(music); }

    public int deleteById(Long id) { return musicMapper.deleteById(id); }

    public List<Music> getAll() { return musicMapper.selectList(null); }

    public Music getById(Long id) { return musicMapper.selectById(id); }


    public List<Music> searchMusicByBuyRangeAndSort(Integer min, Integer max, String sort) {
        return musicMapper.searchByBuyRangeAndSort(min, max, sort);
    }

    public List<Music> searchMusicBySellRangeAndSort(Integer min, Integer max, String sort) {
        return musicMapper.searchBySellRangeAndSort(min, max, sort);
    }

    public List<Music> searchMusicByColor1(String color1) {
        return musicMapper.findByColor1(color1);
    }

    public List<Music> searchMusicByColor2(String color2) {
        return musicMapper.findByColor2(color2);
    }

    public List<Music> searchMusicBySize(String size) {
        return musicMapper.findBySize(size);
    }

    public List<Music> searchMusicBySource(String source) {
        return musicMapper.findBySource(source);
    }

    public List<Music> searchMusicBySourceNotes(String sourceNotes) {
        return musicMapper.findBySourceNotes(sourceNotes);
    }

    public List<Music> searchMusicByCatalog(String catalog) {
        return musicMapper.findByCatalog(catalog);
    }
}
