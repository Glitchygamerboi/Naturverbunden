/*
 * Naturverbunden
 * Copyright (C) 2021 Valoeghese
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package valoeghese.naturverbunden.worldgen.terrain.type;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

/**
 * Represents a mixed mountain edge sample at a position.
 */
public class MountainEdgeTerrainType extends EdgeTerrainType {
	public MountainEdgeTerrainType(TerrainType mix, TerrainType mountains, double mountainousness, boolean hills, boolean useHotMountainEdges) {
		super(mix, mountains, mountainousness, mountainousness > 0.3 ? (useHotMountainEdges ? DUMMY_SHATTERED_SAVANNAH_PLATEAU : (hills ? DUMMY_WOODED_MOUNTAINS : mountains)) : mix);
	}

	private static final TerrainType DUMMY_WOODED_MOUNTAINS = new FlatTerrainType(BiomeKeys.WOODED_MOUNTAINS, 0, Biome.Category.EXTREME_HILLS);
	private static final TerrainType DUMMY_SHATTERED_SAVANNAH_PLATEAU = new FlatTerrainType(BiomeKeys.SHATTERED_SAVANNA_PLATEAU, 0, Biome.Category.EXTREME_HILLS);
}

