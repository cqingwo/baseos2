package com.cqwo.base.strategy.rdbs.service;


import com.cqwo.base.core.data.rdbs.repository.users.OnlineTimeRepository;
import com.cqwo.base.core.data.rdbs.repository.users.OnlineUserRepository;
import com.cqwo.base.core.data.rdbs.repository.users.UserDetailRepository;
import com.cqwo.base.core.data.rdbs.repository.users.UserTokenRepository;
import com.cqwo.base.core.data.rdbs.IUserStrategy;
import com.cqwo.base.core.domain.users.OnlineTimeInfo;
import com.cqwo.base.core.domain.users.OnlineUserInfo;
import com.cqwo.base.core.domain.users.UserDetailInfo;
import com.cqwo.base.core.domain.users.UserTokenInfo;
import com.cqwo.base.core.helper.UnixTimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component(value = "UserStrategy")
public class UserStrategy extends RDBSService implements IUserStrategy {


    @Autowired
    UserDetailRepository userDetailRepository;

    //region 用户详情

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getUserDetailCount(Specification<UserDetailInfo> condition) throws IOException {

        return userDetailRepository.count();
    }


    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) throws IOException {

        return userDetailRepository.save(userdetailInfo);
    }


    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    @Override
    public UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) throws IOException {

        if (userdetailInfo.getId() >= 1) {
            return userDetailRepository.save(userdetailInfo);
        }

        return userdetailInfo;

    }


    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    @Override
    public void deleteUserDetailById(Integer id) throws IOException {

        userDetailRepository.deleteById(id);
    }

    /**
     * 批量删除一批用户详情数据
     **/
    @Override
    public void deleteUserDetailByIdList(String idlist) throws IOException {


    }

    /**
     * 获得用户详情一条记录
     *
     * @param id id
     * @return 返回一条UserDetailInfo
     **/
    @Override
    public UserDetailInfo getUserDetailById(Integer id) throws IOException {
        return userDetailRepository.findById(id).get();
    }


    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    @Override
    public List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return userDetailRepository.findAll(condition, sort);

    }


    /**
     * 获得用户详情数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserDetailInfo
     **/
    @Override
    public Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return userDetailRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    OnlineTimeRepository onlineTimeRepository;

    //region 在线时间统计

    /**
     * 获得在线时间统计数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getOnlineTimeCount(Specification<OnlineTimeInfo> condition) throws IOException {

        return onlineTimeRepository.count();
    }


    /**
     * 创建一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public OnlineTimeInfo createOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {

        return onlineTimeRepository.save(onlinetimeInfo);
    }


    /**
     * 更新一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     **/
    @Override
    public OnlineTimeInfo updateOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {

        if (onlinetimeInfo.getId() >= 1) {
            return onlineTimeRepository.save(onlinetimeInfo);
        }

        return onlinetimeInfo;

    }


    /**
     * 删除一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    @Override
    public void deleteOnlineTimeById(Integer id) throws IOException {

        onlineTimeRepository.deleteById(id);
    }

    /**
     * 批量删除一批在线时间统计数据
     **/
    @Override
    public void deleteOnlineTimeByIdList(String idlist) throws IOException {


    }

    /**
     * 获得在线时间统计一条记录
     *
     * @param id id
     * @return 返回一条OnlineTimeInfo
     **/
    @Override
    public OnlineTimeInfo getOnlineTimeById(Integer id) throws IOException {
        return onlineTimeRepository.findById(id).get();
    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineTimeInfo
     **/
    @Override
    public List<OnlineTimeInfo> getOnlineTimeList(Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return onlineTimeRepository.findAll(condition, sort);

    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineTimeInfo
     **/
    @Override
    public Page<OnlineTimeInfo> getOnlineTimeList(Integer pageSize, Integer pageNumber, Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return onlineTimeRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    private UserTokenRepository userTokenRepository;

    //region 用户token


    /**
     * 更新用户的token信息
     *
     * @param userTokenInfo 用户模型
     * @return 返回创建信息
     **/
    @Override
    public UserTokenInfo updateUserToken(UserTokenInfo userTokenInfo) throws IOException {


        return userTokenRepository.save(userTokenInfo);
    }


    /**
     * 删除过期token
     */
    @Override
    public void deleteLitmitToken() throws IOException {
        Integer timestamp = UnixTimeHelper.getUnixTimeStamp();
        userTokenRepository.deleteLitmitToken(timestamp);
    }


    /**
     * 获取token
     *
     * @param uid
     * @return
     */
    @Override
    public UserTokenInfo findUserToken(String uid) throws IOException {
        return userTokenRepository.findFirstByUid(uid);
    }


    //endregion


    @Autowired
    OnlineUserRepository onlineUserRepository;


    //region 在线用户

    /**
     * 获得在线用户数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getOnlineUserCount(Specification<OnlineUserInfo> condition) throws IOException {

        return onlineUserRepository.count();
    }


    /**
     * 创建一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public OnlineUserInfo createOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {

        return onlineUserRepository.save(onlineuserInfo);
    }


    /**
     * 更新一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     **/
    @Override
    public OnlineUserInfo updateOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {

        if (onlineuserInfo.getOlId() >= 1) {
            return onlineUserRepository.save(onlineuserInfo);
        }

        return onlineuserInfo;

    }


    /**
     * 删除一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    @Override
    public void deleteOnlineUserByOlid(Integer olid) throws IOException {

        onlineUserRepository.deleteById(olid);
    }

    /**
     * 批量删除一批在线用户数据
     **/
    @Override
    public void deleteOnlineUserByOlidList(String olidlist) throws IOException {


    }

    /**
     * 获得在线用户一条记录
     *
     * @param olid olid
     * @return 返回一条OnlineUserInfo
     **/
    @Override
    public OnlineUserInfo getOnlineUserByOlid(Integer olid) throws IOException {
        return onlineUserRepository.findById(olid).get();
    }


    /**
     * 获得在线用户数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineUserInfo
     **/
    @Override
    public List<OnlineUserInfo> getOnlineUserList(Specification<OnlineUserInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "olId");
        }

        return onlineUserRepository.findAll(condition, sort);

    }


    /**
     * 获得在线用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineUserInfo
     **/
    @Override
    public Page<OnlineUserInfo> getOnlineUserList(Integer pageSize, Integer pageNumber, Specification<OnlineUserInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "olId");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return onlineUserRepository.findAll(condition, pageable);


    }


    //endregion

}
