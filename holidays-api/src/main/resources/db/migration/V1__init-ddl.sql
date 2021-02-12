------------------------
-- TABLE: public_holiday
------------------------

CREATE TABLE public_holiday (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    date DATE NOT NULL,
    country CHAR(2)
);

CREATE INDEX idx_public_holiday_1 ON public_holiday(date);
CREATE INDEX idx_public_holiday_2 ON public_holiday(country);

INSERT INTO public_holiday (name, date, country) VALUES ('New Year''s Day', '2021-01-01', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Human Rights Day', '2021-03-22', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Good Friday', '2021-04-02', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Family Day', '2021-04-05', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Freedom Day', '2021-04-27', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('International Workers'' Day', '2021-05-01', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Youth Day', '2021-06-16', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('National Women''s Day', '2021-08-09', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Heritage Day', '2021-09-24', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Day of Reconciliation', '2021-12-16', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Christmas Day', '2021-12-25', 'SA');
INSERT INTO public_holiday (name, date, country) VALUES ('Boxing Day', '2021-12-27', 'SA');
