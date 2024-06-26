package com.ecnudbcourse.acnhdb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecnudbcourse.acnhdb.entity.Housewares;
import com.ecnudbcourse.acnhdb.dto.HousewaresMaterials;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface HousewaresMapper extends BaseMapper<Housewares> {

    @Select("SELECT * FROM housewares WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Housewares> findByName(@Param("name") String name);

    @Insert("INSERT INTO housewares (Name, Variation, Body_Title, Pattern, Pattern_Title, DIY, Body_Customize, Pattern_Customize, Kit_Cost, Buy_Price, Sell_Price, Miles_Price, Color1, Color2, Size, Interact, Tag, Outdoor, Source, Source_Notes, HHA_Concept1, HHA_Concept2, HHA_Series, HHA_Set, Speaker_Type, Lighting_Type) VALUES (#{name}, #{variation}, #{bodyTitle}, #{pattern}, #{patternTitle}, #{diy}, #{bodyCustomize}, #{patternCustomize}, #{kitCost}, #{buyPrice}, #{sellPrice}, #{milesPrice}, #{color1}, #{color2}, #{size}, #{interact}, #{tag}, #{outdoor}, #{source}, #{sourceNotes}, #{hhaConcept1}, #{hhaConcept2}, #{hhaSeries}, #{hhaSet}, #{speakerType}, #{lightingType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertHousewares(Housewares housewares);

    @Update("UPDATE housewares SET Name = #{name}, Variation = #{variation}, Body_Title = #{bodyTitle}, Pattern = #{pattern}, Pattern_Title = #{patternTitle}, DIY = #{diy}, Body_Customize = #{bodyCustomize}, Pattern_Customize = #{patternCustomize}, Kit_Cost = #{kitCost}, Buy_Price = #{buyPrice}, Sell_Price = #{sellPrice}, Miles_Price = #{milesPrice}, Color1 = #{color1}, Color2 = #{color2}, Size = #{size}, Interact = #{interact}, Tag = #{tag}, Outdoor = #{outdoor}, Source = #{source}, Source_Notes = #{sourceNotes}, HHA_Concept1 = #{hhaConcept1}, HHA_Concept2 = #{hhaConcept2}, HHA_Series = #{hhaSeries}, HHA_Set = #{hhaSet}, Speaker_Type = #{speakerType}, Lighting_Type = #{lightingType} WHERE id = #{id}")
    int updateHousewares(Housewares housewares);

    @Delete("DELETE FROM housewares WHERE id = #{id}")
    int deleteById(@Param("id") Long id);


    @Select("<script>" +
            "SELECT * FROM housewares" +
            " WHERE 1=1 AND miles_Price != 0" +
            "<if test='min != null'> AND miles_Price &gt;= #{min}</if>" +
            "<if test='max != null'> AND miles_Price &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY miles_Price ${sort}" +
            "</if>" +
            "</script>")
    List<Housewares> searchByMilesPriceRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("<script>" +
            "SELECT * FROM housewares" +
            " WHERE 1=1 AND buy_price != 0" +
            "<if test='min != null'> AND buy_price &gt;= #{min}</if>" +
            "<if test='max != null'> AND buy_price &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY buy_price ${sort}" +
            "</if>" +
            "</script>")
    List<Housewares> searchByBuyPriceRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("<script>" +
            "SELECT * FROM housewares" +
            " WHERE 1=1 AND sell_price != 0" +
            "<if test='min != null'> AND sell_price &gt;= #{min}</if>" +
            "<if test='max != null'> AND sell_price &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY sell_price ${sort}" +
            "</if>" +
            "</script>")
    List<Housewares> searchBySellPriceRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("<script>" +
            "SELECT * FROM housewares" +
            " WHERE 1=1 AND kit_cost != 0" +
            "<if test='min != null'> AND kit_cost &gt;= #{min}</if>" +
            "<if test='max != null'> AND kit_cost &lt;= #{max}</if>" +
            "<if test='sort != null'>" +
            " ORDER BY kit_cost ${sort}" +
            "</if>" +
            "</script>")
    List<Housewares> searchByKitCostRangeAndSort(@Param("min") Integer min, @Param("max") Integer max, @Param("sort") String sort);

    @Select("SELECT * FROM housewares WHERE Variation LIKE CONCAT('%', #{variation}, '%')")
    List<Housewares> findByVariation(@Param("variation") String variation);

    @Select("SELECT * FROM housewares WHERE Body_Title LIKE CONCAT('%', #{bodyTitle}, '%')")
    List<Housewares> findByBodyTitle(@Param("bodyTitle") String bodyTitle);

    @Select("SELECT * FROM housewares WHERE Pattern LIKE CONCAT('%', #{pattern}, '%')")
    List<Housewares> findByPattern(@Param("pattern") String pattern);

    @Select("SELECT * FROM housewares WHERE Pattern_Title LIKE CONCAT('%', #{patternTitle}, '%')")
    List<Housewares> findByPatternTitle(@Param("patternTitle") String patternTitle);

    @Select("SELECT * FROM housewares WHERE DIY LIKE CONCAT('%', #{diy}, '%')")
    List<Housewares> findByDiy(@Param("diy") String diy);

    @Select("SELECT * FROM housewares WHERE Body_Customize LIKE CONCAT('%', #{bodyCustomize}, '%')")
    List<Housewares> findByBodyCustomize(@Param("bodyCustomize") String bodyCustomize);

    @Select("SELECT * FROM housewares WHERE Pattern_Customize LIKE CONCAT('%', #{patternCustomize}, '%')")
    List<Housewares> findByPatternCustomize(@Param("patternCustomize") String patternCustomize);

    @Select("SELECT * FROM housewares WHERE Color1 LIKE CONCAT('%', #{color1}, '%')")
    List<Housewares> findByColor1(@Param("color1") String color1);

    @Select("SELECT * FROM housewares WHERE Color2 LIKE CONCAT('%', #{color2}, '%')")
    List<Housewares> findByColor2(@Param("color2") String color2);

    @Select("SELECT * FROM housewares WHERE Size LIKE CONCAT('%', #{size}, '%')")
    List<Housewares> findBySize(@Param("size") String size);

    @Select("SELECT * FROM housewares WHERE Interact LIKE CONCAT('%', #{interact}, '%')")
    List<Housewares> findByInteract(@Param("interact") String interact);

    @Select("SELECT * FROM housewares WHERE Tag LIKE CONCAT('%', #{tag}, '%')")
    List<Housewares> findByTag(@Param("tag") String tag);

    @Select("SELECT * FROM housewares WHERE Outdoor LIKE CONCAT('%', #{outdoor}, '%')")
    List<Housewares> findByOutdoor(@Param("outdoor") String outdoor);

    @Select("SELECT * FROM housewares WHERE Source LIKE CONCAT('%', #{source}, '%')")
    List<Housewares> findBySource(@Param("source") String source);

    @Select("SELECT * FROM housewares WHERE Source_Notes LIKE CONCAT('%', #{sourceNotes}, '%')")
    List<Housewares> findBySourceNotes(@Param("sourceNotes") String sourceNotes);

    @Select("SELECT * FROM housewares WHERE HHA_Concept1 LIKE CONCAT('%', #{hhaConcept1}, '%')")
    List<Housewares> findByHhaConcept1(@Param("hhaConcept1") String hhaConcept1);

    @Select("SELECT * FROM housewares WHERE HHA_Concept2 LIKE CONCAT('%', #{hhaConcept2}, '%')")
    List<Housewares> findByHhaConcept2(@Param("hhaConcept2") String hhaConcept2);

    @Select("SELECT * FROM housewares WHERE HHA_Series LIKE CONCAT('%', #{hhaSeries}, '%')")
    List<Housewares> findByHhaSeries(@Param("hhaSeries") String hhaSeries);

    @Select("SELECT * FROM housewares WHERE HHA_Set LIKE CONCAT('%', #{hhaSet}, '%')")
    List<Housewares> findByHhaSet(@Param("hhaSet") String hhaSet);

    @Select("SELECT * FROM housewares WHERE Speaker_Type LIKE CONCAT('%', #{speakerType}, '%')")
    List<Housewares> findBySpeakerType(@Param("speakerType") String speakerType);

    @Select("SELECT * FROM housewares WHERE Lighting_Type LIKE CONCAT('%', #{lightingType}, '%')")
    List<Housewares> findByLightingType(@Param("lightingType") String lightingType);

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
            "       housewares h" +
            "   JOIN" +
            "       recipes r ON h.Name = r.Name" +
            "   WHERE" +
            "       h.Name LIKE CONCAT('%', #{name}, '%')" +
            "   AND h.DIY = 'yes'")
    List<HousewaresMaterials> selectHousewaresMaterialsByName(@Param("name") String name);
}
