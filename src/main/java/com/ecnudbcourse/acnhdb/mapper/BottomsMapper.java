package com.ecnudbcourse.acnhdb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecnudbcourse.acnhdb.entity.Bottoms;
import com.ecnudbcourse.acnhdb.dto.BottomsMaterials;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BottomsMapper extends BaseMapper<Bottoms> {

    @Select("SELECT * FROM bottoms WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Bottoms> findByName(@Param("name") String name);

    @Insert("INSERT INTO bottoms (Name, Variation, DIY, Buy, Sell, Color1, Color2, Source, Source_Notes, Seasonal_Availability, Mannequin_Piece, Style, Label_Themes, Catalog) VALUES (#{name}, #{variation}, #{diy}, #{buy}, #{sell}, #{color1}, #{color2}, #{source}, #{sourceNotes}, #{seasonalAvailability}, #{mannequinPiece}, #{style}, #{labelThemes}, #{catalog})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertBottoms(Bottoms bottoms);

    @Update("UPDATE bottoms SET Name = #{name}, Variation = #{variation}, DIY = #{diy}, Buy = #{buy}, Sell = #{sell}, Color1 = #{color1}, Color2 = #{color2}, Source = #{source}, Source_Notes = #{sourceNotes}, Seasonal_Availability = #{seasonalAvailability}, Mannequin_Piece = #{mannequinPiece}, Style = #{style}, Label_Themes = #{labelThemes}, Catalog = #{catalog} WHERE id = #{id}")
    int updateBottoms(Bottoms bottoms);

    @Delete("DELETE FROM bottoms WHERE id = #{id}")
    int deleteById(@Param("id") Long id);


    @Select("<script>" +
            "SELECT * FROM bottoms" +
            " WHERE 1=1 AND buy != 0" +
            "<if test='min != null'> AND buy &gt;= #{min}</if>" +
            "<if test='max != null'> AND buy &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY buy ${sort}" +
            "</if>" +
            "</script>")
    List<Bottoms> searchByBuyRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("<script>" +
            "SELECT * FROM bottoms" +
            " WHERE 1=1 AND sell != 0" +
            "<if test='min != null'> AND sell &gt;= #{min}</if>" +
            "<if test='max != null'> AND sell &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY sell ${sort}" +
            "</if>" +
            "</script>")
    List<Bottoms> searchBySellRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("SELECT * FROM bottoms WHERE Variation LIKE CONCAT('%', #{variation}, '%')")
    List<Bottoms> findByVariation(@Param("variation") String variation);

    @Select("SELECT * FROM bottoms WHERE DIY LIKE CONCAT('%', #{diy}, '%')")
    List<Bottoms> findByDiy(@Param("diy") String diy);

    @Select("SELECT * FROM bottoms WHERE Color1 LIKE CONCAT('%', #{color1}, '%')")
    List<Bottoms> findByColor1(@Param("color1") String color1);

    @Select("SELECT * FROM bottoms WHERE Color2 LIKE CONCAT('%', #{color2}, '%')")
    List<Bottoms> findByColor2(@Param("color2") String color2);

    @Select("SELECT * FROM bottoms WHERE Source LIKE CONCAT('%', #{source}, '%')")
    List<Bottoms> findBySource(@Param("source") String source);

    @Select("SELECT * FROM bottoms WHERE Source_Notes LIKE CONCAT('%', #{sourceNotes}, '%')")
    List<Bottoms> findBySourceNotes(@Param("sourceNotes") String sourceNotes);

    @Select("SELECT * FROM bottoms WHERE Seasonal_Availability LIKE CONCAT('%', #{seasonalAvailability}, '%')")
    List<Bottoms> findBySeasonalAvailability(@Param("seasonalAvailability") String seasonalAvailability);

    @Select("SELECT * FROM bottoms WHERE Mannequin_Piece LIKE CONCAT('%', #{mannequinPiece}, '%')")
    List<Bottoms> findByMannequinPiece(@Param("mannequinPiece") String mannequinPiece);

    @Select("SELECT * FROM bottoms WHERE Style LIKE CONCAT('%', #{style}, '%')")
    List<Bottoms> findByStyle(@Param("style") String style);

    @Select("SELECT * FROM bottoms WHERE Label_Themes LIKE CONCAT('%', #{labelThemes}, '%')")
    List<Bottoms> findByLabelThemes(@Param("labelThemes") String labelThemes);

    @Select("SELECT * FROM bottoms WHERE Catalog = #{catalog}")
    List<Bottoms> findByCatalog(@Param("catalog") String catalog);

    @Select("SELECT" +
            "   COALESCE(r.name, '') AS name," +
            "   COALESCE(r.Number_Of_Material1, '') AS number_of_material1," +
            "   COALESCE(r.Number_Of_Material2, '') AS number_of_material2," +
            "   COALESCE(r.Number_Of_Material3, '') AS number_of_material3," +
            "   COALESCE(r.Number_Of_Material4, '') AS number_of_material4," +
            "   COALESCE(r.Number_Of_Material5, '') AS number_of_material5," +
            "   COALESCE(r.Number_Of_Material6, '') AS number_of_material6," +

            "   COALESCE(r.Material1, '') AS material1," +
            "   COALESCE(r.Material2, '') AS material2," +
            "   COALESCE(r.Material3, '') AS material3," +
            "   COALESCE(r.Material4, '') AS material4," +
            "   COALESCE(r.Material5, '') AS material5," +
            "   COALESCE(r.Material6, '') AS material6" +
            "   FROM" +
            "       bottoms h" +
            "   JOIN" +
            "       recipes r ON h.Name = r.Name" +
            "   WHERE" +
            "       h.Name LIKE CONCAT('%', #{name}, '%')" +
            "   AND h.DIY = 'yes'")
    List<BottomsMaterials> selectBottomsMaterialsByName(@Param("name") String name);
}
