package com.weido.create_bb.blocks.sizes;

import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import java.util.function.Supplier;

import com.weido.create_bb.blocks.BBBogieBlock;

public class SmallBogieBlock extends BBBogieBlock {
    protected SmallBogieBlock(Properties props, Supplier<BogeyStyle> defaultStyle, BogeySize size) {
        super(props, defaultStyle, size);
    }
}
