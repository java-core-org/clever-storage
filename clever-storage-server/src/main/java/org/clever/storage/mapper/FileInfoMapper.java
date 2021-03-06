package org.clever.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.clever.storage.entity.FileInfo;
import org.springframework.stereotype.Repository;

/**
 * 作者： lzw<br/>
 * 创建时间：2018-12-25 11:42 <br/>
 */
@Repository
@Mapper
public interface FileInfoMapper extends BaseMapper<FileInfo> {

    @Select("select * from file_info where digest=#{digest} and digest_type=#{digestType} and stored_type=#{storedType} limit 1")
    FileInfo getFileInfoByDigest(@Param("digest") String digest, @Param("digestType") Integer digestType, @Param("storedType") Integer storedType);

    @Select("select * from file_info where digest=#{digest} and file_path=#{filePath} and new_name=#{newName} limit 1")
    FileInfo getByDigestAndPath(@Param("digest") String digest, @Param("filePath") String filePath, @Param("newName") String newName);

    @Select("select * from file_info where new_name=#{newName} and stored_type=#{storedType} limit 1")
    FileInfo getByNewName(@Param("newName") String newName, @Param("storedType") Integer storedType);
}
