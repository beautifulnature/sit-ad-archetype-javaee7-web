package org.sitoolkit.ad.archetype.tips.presentation;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.sitoolkit.ad.archetype.tips.application.user.UserService;
import org.sitoolkit.ad.archetype.tips.domain.code.GenderCd;
import org.sitoolkit.ad.archetype.tips.domain.user.UserEntity;
import org.sitoolkit.ad.archetype.tips.infrastructure.code.CodeUtils;
import org.sitoolkit.ad.archetype.tips.infrastructure.entitycrud.EntityInputController;

@Named
@ViewScoped
public class UserInputController extends EntityInputController<UserEntity, String, UserService>
        implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * ユーザーID
     */
    private String userId;

    @Inject
    transient UserService service;

    public GenderCd[] getGender() {
        return GenderCd.values();
    }

    public GenderCd decodeGender(String code) {
        return CodeUtils.decode(code, GenderCd.class);
    }

    @Override
    protected UserService getService() {
        return service;
    }

    @Override
    protected String getEntityId() {
        return getUserId();
    }

    /**
     * ユーザーIDを返却する。
     *
     * @return ユーザーID
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * ユーザーIDを設定する。
     *
     * @param userId
     *            ユーザーID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
