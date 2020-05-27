package com.big407.energy.mapper;

import com.big407.energy.model.GithubUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GithubMapper {

    @Insert("insert into github (account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void create(GithubUser githubUser);

    @Update("update github set account_id=#{accountId},name=#{name},token=#{token},gmt_create=#{gmtCreate},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(GithubUser githubUser);

    @Select("select * from github where account_id=#{accountId}")
    GithubUser findById(String accountId);

    @Select("select * from  github where token=#{token}")
    GithubUser findGithubUserByToken(String token);

    @Select("select count(*) from github")
    int countGithubUser();
}
