package service;

import entity.Calam;
import entity.ChitietCalam;

public interface ChitietCalamService {
	ChitietCalam getChitietCalamById(String id, Calam calam);
}
