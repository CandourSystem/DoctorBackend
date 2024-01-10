package org.cs.jwt.repository;

import org.cs.jwt.model.QUserOSDParameterRange;
import org.cs.jwt.model.UserOSDParameterRange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;

public interface UserOSDParameterRangeRepository
                extends JpaRepository<UserOSDParameterRange, Long>,
                QuerydslPredicateExecutor<UserOSDParameterRange>,
                QuerydslBinderCustomizer<QUserOSDParameterRange> {

        @Override
        default void customize(QuerydslBindings bindings,
                        QUserOSDParameterRange qUserOSDParameterRange) {
                bindings.excluding(
                                // excluding some fields from filter
                                qUserOSDParameterRange.validflag);

        }

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where  rm.validflag='Yes' and rm.userid=:userid")
        Page<UserOSDParameterRange> findAll(@Param("userid") Integer userid, Pageable pageable);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where  rm.validflag='Yes' and rm.parametertypeid=:parametertypeid and rm.deviceid = uuidfromstring(:deviceid) and rm.userid=:userid")
        UserOSDParameterRange findByUserDeviceIdParameterId(@Param("deviceid") String deviceid,
                        @Param("parametertypeid") Integer parameterid, @Param("userid") Integer userid);

       

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.validflag='Yes' and rm.deviceid=uuidfromstring(:deviceid) and rm.userid=:userid")
        Page<UserOSDParameterRange> findAllByUserDeviceid(@Param("deviceid") String deviceid,
                        Pageable pageable, @Param("userid") Integer userid);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.validflag='Yes' and  rm.organizationid=:organizationid and rm.userid=:userid")
        Page<UserOSDParameterRange> findAllByUserOrganizationid(
                        @Param("organizationid") Integer organizationid, @Param("userid") Integer userid,
                        Pageable pageable);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.validflag='Yes' and rm.organizationid=:organizationid and stationid=:stationid and rm.userid=:userid")
        Page<UserOSDParameterRange> findAllByUserOrganizationStationid(
                        @Param("organizationid") Integer organizationid, @Param("stationid") Integer stationid,
                        @Param("userid") Integer userid,
                        Pageable pageable);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.deviceid=uuidfromstring(:deviceid) and rm.userid=:userid")
        Page<UserOSDParameterRange> findAllByUserOrganizationStationDeviceid(
                        @Param("deviceid") String deviceid, @Param("userid") Integer userid, Pageable pageable);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.parametertypeid=:parametertypeid and rm.deviceid=uuidfromstring(:deviceid) and rm.userid=:userid")
        Page<UserOSDParameterRange> findAllByUserOrganizationStationDeviceParametertypeid(
                        @Param("deviceid") String deviceid, @Param("userid") Integer userid,@Param("parametertypeid") Integer parametetypeid, Pageable pageable);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where  osdp_id=:osdpId and rm.userid=:userid")
        UserOSDParameterRange findByUserOsdpId(@Param("osdpId") String osdpId, @Param("userid") Integer userid);

        @Query(nativeQuery = true, value = "select rm.* from m_userosdparameterrange rm where rm.parametertypeid=:parametertypeid and rm.deviceid=uuidfromstring(:deviceid) and rm.userid=:userid")
        UserOSDParameterRange findByUserDeviceParameterId( @Param("deviceid") String deviceid, @Param("parametertypeid") Integer parametetypeid,@Param("userid") Integer userid);

}