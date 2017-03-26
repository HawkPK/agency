				<div class="form-group">
					<label class="col-sm-2 control-label">Name:</label>
					<div class="col-sm-10">
						<select th:field="*{surname}">
							<option th:each="type : ${category}" th:value="${type}"
								th:text="#{${type}}">Wireframe</option>
						</select>
					</div>
				</div>