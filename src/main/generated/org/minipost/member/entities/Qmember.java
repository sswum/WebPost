package org.minipost.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qmember is a Querydsl query type for member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qmember extends EntityPathBase<member> {

    private static final long serialVersionUID = -762215072L;

    public static final Qmember member = new Qmember("member1");

    public final StringPath email = createString("email");

    public final StringPath password = createString("password");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public Qmember(String variable) {
        super(member.class, forVariable(variable));
    }

    public Qmember(Path<? extends member> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qmember(PathMetadata metadata) {
        super(member.class, metadata);
    }

}

